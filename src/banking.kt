fun registerAccountName() :String {
    // ask for account name and return the string value
    println("Register Account Name")
    print("Account Name: ")
    return readln()
}

fun depositAccount(accountName: String, balance: Double): Double {
    // ask for deposit amount
    println("\nDeposit Amount")
    println("Account Name: ₱$accountName")
    println("Current Balance: ₱$balance")
    println("Currency: PHP\n")

    print("Deposit Amount: ")

    val deposit = readln().toDouble()
    val updatedBalance = balance + deposit

    println("Updated Balance: ₱$updatedBalance")

    return updatedBalance
}

fun withdrawAccount(accountName: String, balance: Double): Double {
    println("\nWithdraw Amount")
    println("Account Name: ₱$accountName")
    println("Current Balance: ₱$balance")
    println("Currency: PHP\n")

    print("Withdraw Amount: ")

    val withdraw = readln().toDouble()
    val updatedBalance = balance - withdraw

    println("Updated Balance: ₱$updatedBalance")

    return updatedBalance
}

fun showExchangeRate() {
    println("Record Exhcange Rate")
    println("[1] Philippine Peso (PHP)")
    println("[2] United States Dollar (USD)")
    println("[3] Japanese Yen (JPY)")
    println("[4] British Pound Sterling (GBP)")
    println("[5] Euro (EUR)")
    println("[6] Chinese Yuan Renminni (CNY)")

    print("Seclect Foreign Currency: ")
    val currencyChoice = readln().toInt()

    println("Exchange Rate: ${
        when (currencyChoice) {
            1 -> 1.00
            2 -> 60.85
            3 -> 0.38
            4 -> 81.55
            5 -> 70.38
            6 -> 8.98
            else -> 0.0
        }
    }")
}

fun currencyExchange() {
    var flag = true

    while (flag) {

        val rates = mapOf(
            1 to 1.00,
            2 to 60.85,
            3 to 0.38,
            4 to 81.55,
            5 to 70.38,
            6 to 8.98,
        )

        println("Foreign Currency Exchange (June 12 rate)")
        println("Source Currency Option:")
        println("[1] Philippine Peso (PHP)")
        println("[2] United States Dollar (USD)")
        println("[3] Japanese Yen (JPY)")
        println("[4] British Pound Sterling (GBP)")
        println("[5] Euro (EUR)")
        println("[6] Chinese Yuan Renminni (CNY)\n")

        print("Source Currency: ")
        val choice1 = readln().toInt()

        print("Source Amount: ")
        val amount1 = readln().toFloat()

        println("\nExchange Currency Options:")
        println("[1] Philippine Peso (PHP)")
        println("[2] United States Dollar (USD)")
        println("[3] Japanese Yen (JPY)")
        println("[4] British Pound Sterling (GBP)")
        println("[5] Euro (EUR)")
        println("[6] Chinese Yuan Renminni (CNY)\n")

        print("Source Currency: ")

        val choice2 = readln().toInt()
        val phpAmount = amount1 * rates[choice1]!!
        val exchangedAmount = phpAmount / rates[choice2]!!

        println("Exchange Amount: %.2f".format(exchangedAmount))

        print("Convert another currency (Y/N)? ")
        val answer = readln().uppercase()
        if (answer == "N") {
            println("")
            flag = false
        }

    }
}

fun interestAmount(accountName: String, balance: Double) {
    val annualInterest = 0.05f

    println("Show Interest Amount")
    println("Account Name: $accountName")
    println("Current Balance: ₱$balance")
    println("Currency: PHP")
    println("Interest Rate: 5%\n")

    print("Total Number of Days: ")
    val days = readln().toInt()

    var interestBalance = balance
    println("\nDay   | Interest   | Balance")
    println("----------------------------")
    for (day in 1..days) {
        val dailyInterest = interestBalance * (annualInterest / 365)
        interestBalance += dailyInterest

        println(
            "%-5d | %-10.2f | %-10.2f"
                .format(day, dailyInterest, interestBalance)
        )
    }

}

fun backToMainMenu(): Boolean {
    // return true if yes and false if no
    print("\nBack to the Main Menu (Y/N): ")
    val answer = readln().uppercase()
    if (answer == "Y") {
        println("")
        return true
    }
    println("Exiting program...")
    return false
}

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

        println("Select Transaction:")
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
            name = registerAccountName()

            if (!backToMainMenu()) {
                break;
            }

        } else if (response == 2) {

            balance = depositAccount(name, balance)

            if (!backToMainMenu()) {
                break;
            }

        } else if (response == 3) {

            balance = withdrawAccount(name, balance)

            if (!backToMainMenu()) {
                break;
            }

        } else if (response == 4) {

            currencyExchange()

        } else if (response == 5) {
            showExchangeRate()

            if (!backToMainMenu()) {
                break;
            }

        } else if (response == 6) {
            interestAmount(name, balance)

            if (!backToMainMenu()) {
                break;
            }

        } else if (response == 7) {
            flag = false
        }
    }
}