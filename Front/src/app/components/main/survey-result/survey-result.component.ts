import {Component, Input} from '@angular/core';
import {SurveyResultModel} from "../../../models/survey-result.model";

@Component({
  selector: 'app-survey-result',
  templateUrl: './survey-result.component.html',
  styleUrls: ['./survey-result.component.scss']
})
export class SurveyResultComponent {
  @Input() survey!: SurveyResultModel;
}
