import {Component, OnInit} from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {HttpClient} from '@angular/common/http';

interface Operators {
  value: string;
}

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  constructor(private http: HttpClient) {
  }

  operators: Operators[] = [
    {value: '-'},
    {value: '+'},
    {value: '/'},
    {value: '*'},
  ];
  displayedColumns: string[] = ['Calculation', 'Result'];

  url: string = 'http://localhost:8080/calculator'
  allCalculations: any = [];

  firstNumber = new FormControl('', [Validators.required]);
  secondNumber = new FormControl('', [Validators.required]);
  operator = new FormControl('', [Validators.required]);

  ngOnInit(): void {
    this.getCalculations();
  }

  calculate(): void {
    let calculationString: string = this.firstNumber.getRawValue() ?? ""
    calculationString += this.operator.getRawValue()
    calculationString += this.secondNumber.getRawValue()

    this.http.post<any>(this.url, calculationString).subscribe(() => {
      this.getCalculations()
    })
  }

  getCalculations(): void {
    this.http.get<any>(this.url).subscribe(data => {
        this.allCalculations = data;
      }
    )
  }
}



