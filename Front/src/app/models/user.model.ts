export class UserModel {
  id: number;
  login: string;
  firstName: string;
  lastName: string;
  description?: string;
  likes: number[];
  reposts: number[];
  followers: number[] = [];
  followings: number[] = [];
  role: string = '';

  constructor(id: number, login: string, firstName: string, lastName: string, likes: number[],
              reposts: number[], description: string, followers: number[], followings: number[], role: string) {
    this.id = id;
    this.login = login;
    this.firstName = firstName;
    this.lastName = lastName;
    this.likes = likes;
    this.reposts = reposts;
    this.description = description;
    this.followers = followers;
    this.followings = followings;
    this.role = role;
  }
}
