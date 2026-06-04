fun main() {
    var balance: Double = 1000.00
    var interestBalance = 0.00
    var interest = 0.05
    var deposit = 0
    var withdraw = 0
    var currencyChoice = 0
    var sourceCurrency = 0
    var exchangeCurrency = 0
    var days = 0
    var name  = ""
    var answer = ""
    var flag = true

    while (flag) {

        println("Select Transactions")
        println("[1] Register Account Name")
        println("[2] Deposit Amount")
        println("[3] Withdraw Amount")
        println("[4] Currency Exchange")
        println("[5] Record Exchange Rates")
        println("[6] Show Interest Computation")
        println("[7] Exit")
        print("Choose: ")

        val response = readln().toInt()

        if (response == 1) {
            println("Register Account Name")
            print("Account Name: ")
            name = readln()

            print("Back to the Main Menu (Y/N): ")
            answer = readln().uppercase()
            if (answer == "Y") {
                continue
            } else if (answer == "N") {
                println("Exiting program...")
                break
            }

        } else if (response == 2) {
            println("Deposit Amount")
            println("Account Name: $name")
            println("Current Balance: $balance")
            println("Currency: PHP")

            println("Deposit Amount: ")
            deposit = readln().toInt()

            balance += deposit
            println("Updated Balance: $balance")
            print("Back to the Main Menu (Y/N): ")
            answer = readln().uppercase()
            if (answer == "Y") {
                continue
            } else if (answer == "N") {
                println("Exiting program...")
                break
            }

        } else if (response == 3) {
            println("Withdraw Amount")
            println("Account Name: $name")
            println("Current Balance: $balance")
            println("Currency: PHP")

            print("Withdraw Amount: ")
            withdraw = readln().toInt()

            balance += withdraw
            println("Updated Balance: $balance")
            print("Back to the Main Menu (Y/N): ")
            answer = readln().uppercase()
            if (answer == "Y") {
                continue
            } else if (answer == "N") {
                println("Exiting program...")
                break
            }

        } else if (response == 4) {
            println("Record Exhcange Rate")
            println("[1] Philippine Peso (PHP)")
            println("[2] United States Dollar (USD)")
            println("[3] Japanese Yen (JPY)")
            println("[4] British Pound Sterling (GBP)")
            println("[5] Euro (EUR)")
            println("[6] Chinese Yuan Renminni (CNY)")

            print("Seclect Foreign Currency: ")
            currencyChoice = readln().toInt()

            println("Exchange Rate: ${
                when (currencyChoice) {
                    1 -> 1.00
                    2 -> 52.00
                    3 -> 0.35
                    4 -> 67.50
                    5 -> 58.20
                    6 -> 7.20
                    else -> 0.0
                }
            }")

            answer = readln().uppercase()
            if (answer == "Y") {
                continue
            } else if (answer == "N") {
                println("Exiting program...")
                break
            }


        } else if (response == 5) {
            println("Foreign Currency Exhcange")
            println("Source Currency Option:")
            println("[1] Philippine Peso (PHP)")
            println("[2] United States Dollar (USD)")
            println("[3] Japanese Yen (JPY)")
            println("[4] British Pound Sterling (GBP)")
            println("[5] Euro (EUR)")
            println("[6] Chinese Yuan Renminni (CNY)")

            print("Source Currency: ")
            sourceCurrency = readln().toInt()
            // not yet finished

        } else if (response == 6) {
            // fix logic
            println("Show Interest Amount")
            println("Account Name: $name")
            println("Current Balance: $balance")
            println("Currency: PHP")
            println("Interest Rate: 5%\n")

            print("Total Number of Days: ")
            days = readln().toInt()

            interestBalance = balance
            println("\nDay   | Interest   | Balance")
            println("----------------------------")
            for (day in 1..days) {
                interestBalance += interest

                println(
                    "%-5d | %-10.2f | %-10.2f"
                        .format(day, interest, interestBalance)
                )
            }

            answer = readln().uppercase()
            if (answer == "Y") {
                continue
            } else if (answer == "N") {
                println("Exiting program...")
                break
            }

        } else if (response == 7) {
            flag = false
        }
    }

}