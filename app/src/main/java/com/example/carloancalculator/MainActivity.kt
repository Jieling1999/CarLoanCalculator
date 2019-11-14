package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculateLoan()
        }
    }

    private fun calculateLoan(){
        val carPrice=editTextCarPrice.text.toString().toInt()
        val downPayment=editTextDownPayment.text.toString().toInt()
        val loanPeriod=editTextLoanPeriod.text.toString().toInt()
        val interestRate=editTextInterestRate.text.toString().toFloat()

        val loan=carPrice-downPayment;
        val interest=loan*interestRate*loanPeriod
        val monRepay=(loan+interest)/loanPeriod/12

        textViewLoan.text=getString(R.string.loan)+": ${loan}"
        textViewInterest.text=getString(R.string.interest)+": ${interest}"
        textViewMonthlyRepayment.text=getString(R.string.monthly_repayment)+": ${monRepay}"

    }

    fun resetInput(view: View) {
        editTextCarPrice.text=null
        editTextDownPayment.text=null
        editTextLoanPeriod.text=null
        editTextInterestRate.text=null
        textViewLoan.text=null
        textViewInterest.text=null
        textViewMonthlyRepayment.text=null
    }
}
