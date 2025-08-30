# Plan 2 student loan repayment projector

On a Plan 2 loan, by default, you pay 9% of your income over the monthly repayment threshold, which is currently £2,372.

A Plan 2 loan is written off 30 years after the first April in which you were due to repay.

On a Plan 2 loan, your interest rate varies with your monthly income,
and anyone making at least £51,245 pays the top interest rate, which is
normally the RPI plus up to 3%, depending on your income.

See:
- https://www.gov.uk/repaying-your-student-loan/what-you-pay
- https://www.gov.uk/guidance/how-interest-is-calculated-plan-2
- https://www.gov.uk/guidance/previous-annual-repayment-thresholds

## Overseas graduates

If you're living and working overseas, the thresholds are different. They are adjusted based on the living costs in each individual country and the exchange rate for the local currency.

The loans company asks you to update them with your salary information to calculate your repayment amount, but if you don't, they give you a repayment threshold under the assumption that you make double the median working age graduate salary in England as sourced from the most recently published graduate labour market statistics. This assumed salary will then be adjusted based on the Price Level Index band for the country you live in, before being applied as if that were your reported salary.

The exchange rates for each currency are taken from the most recent report of the average exchange rates published by HMRC.

See:
- https://www.gov.uk/government/publications/overseas-earnings-thresholds-for-plan-2-student-loans
- https://www.practitioners.slc.co.uk/media/2096/sfe-repayments-guidance-ay-25-26-v10.pdf
- https://explore-education-statistics.service.gov.uk/find-statistics/graduate-labour-markets
- https://www.trade-tariff.service.gov.uk/exchange_rates/average

### Past repayment thresholds

Dates 	                        Annual repayment threshold
6 April 2016 to 5 April 2018 	£21,000
6 April 2018 to 5 April 2019 	£25,000
6 April 2019 to 5 April 2020 	£25,725
6 April 2020 to 5 April 2021 	£26,575
6 April 2021 to 5 April 2025 	£27,295

### Past maximum interest rates as of 2025

Date 	                                Interest rate
1 August 2024 to 31 August 2024 	    8%
1 June 2024 to 31 July 2024 	        7.9%
1 April 2024 to 31 May 2024 	        7.8%
1 March 2024 to 31 March 2024 	        7.7%
1 January 2024 to 29 February 2024 	    7.6%
1 December 2023 to 31 December 2023 	7.5%
1 September 2023 to 30 November 2023 	7.3%
1 June 2023 to 31 August 2023 	        7.1%
1 March 2023 to 31 May 2023 	        6.9%
1 December 2022 to 28 February 2023 	6.5%
1 September 2022 to 30 November 2022 	6.3%
1 March 2022 to 31 August 2022 	        4.5%
1 January 2022 to 28 February 2022 	    4.4%
1 October 2021 to 31 December 2021 	    4.1%
1 September 2021 to 30 September 2021 	4.2%
1 July 2021 to 31 August 2021 	        5.3%
1 September 2020 to 30 June 2021 	    5.6%
1 September 2019 to 31 August 2020 	    5.4%
1 September 2018 to 31 August 2019 	    6.3%
1 September 2017 to 31 August 2018 	    6.1%
1 September 2016 to 31 August 2017 	    4.6%
1 September 2015 to 31 August 2016 	    3.9%
1 September 2014 to 31 August 2015 	    5.5%
1 September 2013 to 31 August 2014 	    6.3%
1 September 2012 to 31 August 2013 	    6.6%

### Past overseas repayment thresholds

The repayment threshold for those living overseas is different depending on the Price Level Index of the country you are living in. You can use this table along with the information for the current year at the time of writing (e.g.https://www.gov.uk/government/publications/overseas-earnings-thresholds-for-plan-2-student-loans/overseas-earnings-thresholds-for-plan-2-student-loans-2024-25) to determine which repayment band applies to the country where you're living and working.

Financial   Repayment Band and Price Level Index
Year        A 0<30 | B 30<50 | C 50<70 | D 70<90 | E 90<110 | F 110<130 | G 130+
2016-2017   £4,200   £8,400    £12,600   £16,800   £21,000    £25,200     £29,400
2017-2018   £4,200   £8,400    £12,600   £16,800   £21,000    £25,200     £29,400
2018-2019   £5,000   £10,000   £15,000   £20,000   £25,000    £30,000     £35,000
2019-2020   £5,145   £10,290   £15,435   £20,580   £25,725    £30,870     £36,015
2020-2021   £5,315   £10,630   £15,945   £21,260   £26,575    £31,890     £37,205
2021-2022   £5,460   £10,920   £16,380   £21,840   £27,295    £32,755     £38,215
2022-2023   £5,460   £10,920   £16,380   £21,840   £27,295    £32,755     £38,215
2023-2024   £5,460   £10,920   £16,380   £21,840   £27,295    £32,755     £38,215
2024-2025   £5,460   £10,920   £16,380   £21,840   £27,295    £32,755     £38,215
2025-2026   £5,695   £11,390   £17,085   £22,780   £28,470    £34,165     £39,860

### Overseas fixed monthly payment bands

If you don't tell SLC about your income, they will make an assumption of your salary based on graduate salary statistics from England and then adjust them based on the Price Level Index band for the country where you're living and working.

Band    Rate
A       20%
B       40%
C       60%
D       80%
E       100%
F       120%
G       140%

## Usage

I haven't made this really sensible for use by anyone other than myself.

```
./gradlew :advisor:shadowJar
```

```
java -jar advisor/build/libs/advisor-all.jar <args>
```

Or

```
./run.sh
```
