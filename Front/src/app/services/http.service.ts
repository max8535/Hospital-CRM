import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, map} from 'rxjs/operators';
import {API_URL} from "../../utils/constants";

@Injectable({
  providedIn: 'root'
})
export class BaseService {
  constructor(private http: HttpClient) {
  }

  get<T>(url: string, options?: any): Observable<T> {
    return this.http.get<T>(API_URL + url, options).pipe(
      map((response: any) => {
        if (response.error) {
          throw new Error(response);
        }
        return response.data;
      }),
      catchError((error: HttpErrorResponse) => {
        return throwError(() => error || 'Server error');
      })
    );
  }

  post<T>(url: string, data: any, options?: any): Observable<T> {
    return this.http.post<T>(API_URL + url, data, options).pipe(
      map((response: any) => {
        if (response.error) {
          throw new Error(response.error);
        }
        return response.data;
      }),
      catchError((error: HttpErrorResponse) => {
        return throwError(() => error || 'Server error');
      })
    );
  }

  put<T>(url: string, data: any, options?: any): Observable<T> {
    return this.http.put<T>(API_URL + url, data, options).pipe(
      map((response: any) => {
        if (response.error) {
          throw new Error(response.error);
        }
        return response.data;
      }),
      catchError((error: HttpErrorResponse) => {
        return throwError(() => error || 'Server error');
      })
    );
  }

  delete<T>(url: string, options?: any): Observable<T> {
    return this.http.delete<T>(API_URL + url, options).pipe(
      map((response: any) => {
        if (response.error) {
          throw new Error(response.error);
        }
        return response.data;
      }),
      catchError((error: HttpErrorResponse) => {
        return throwError(() => error || 'Server error');
      })
    );
  }
}
