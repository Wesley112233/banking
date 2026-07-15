/*
Last names: Hong
Language: Kotlin
Paradigm(s): object-oriented, functional, imperative
*/

/* global variables */
// exchange rates
val rates = mutableMapOf(
    2 to 0.00,
    3 to 0.00,
    4 to 0.00,
    5 to 0.00,
    6 to 0.00
)

// currency balance
val balances: MutableMap<Int, Double> = mutableMapOf(
    1 to 1000.00,
    2 to 0.00,
    3 to 0.00,
    4 to 0.00,
    5 to 0.00,
    6 to 0.00
)

fun registerAccountName() :String {
    // ask for account name
    println("Register Account Name")
    print("Account Name: ")
    return readln()
}

fun depositAccount(balance: Double): Double {

    // ask for deposit amount
    println("\nCurrent Balance: ₱${"%.2f".format(balance)}")
    print("Deposit Amount: ")

    val deposit = readln().toDouble()
    val updatedBalance = balance + deposit

    if (deposit <= 0) {
        println("Invalid deposit amount.")
        return balance
    }

    println("Updated Balance: ₱${"%.2f".format(updatedBalance)}")
    return updatedBalance
}

fun withdrawAccount(balance: Double): Double {

    println("\nCurrent Balance: ₱${"%.2f".format(balance)}")
    print("Withdraw Amount: ")

    val withdraw = readln().toDouble()
    val updatedBalance = balance - withdraw

    if (withdraw > balance) {
        println("Withdrawal failed: Insufficient balance.")
        return balance
    } else if (withdraw <= 0) {
        println("Invalid withdrawal amount.")
        return balance
    } else {
        println("Updated Balance: ₱${"%.2f".format(updatedBalance)}")
        return updatedBalance
    }

}

fun currencyExchange() {
    val flag = true

    while (flag) {

        println("Rates: ")
        println("[1] Philippine Peso (PHP) - 1.00")
        println("[2] United States Dollar (USD) - ${"%.2f".format(rates[2])}")
        println("[3] Japanese Yen (JPY) - ${"%.2f".format(rates[3])}")
        println("[4] British Pound Sterling (GBP) - ${"%.2f".format(rates[4])}")
        println("[5] Euro (EUR) - ${"%.2f".format(rates[5])}")
        println("[6] Chinese Yuan Renminni (CNY) - ${"%.2f".format(rates[6])}\n")

        print("Source Currency: ")
        val source = readln().toInt()

        if (source !in 1..6) {
            println("Invalid choice. Please try again")
            continue
        }

        if (source != 1 && rates[source] == 0.0) {
            println("Exchange rate has not been recorded yet")
            println("Please record the exchange rate first")
            break
        }

        print("Source Amount: ")
        val amount = readln().toDouble()

        if (amount <= 0) {
            println("Invalid amount")
            continue
        }

        if (amount > balances.getValue(source)) {
            println("Insufficient balance")
            continue
        }

        println("\nExchange Currency Options:")
        println("[1] Philippine Peso (PHP)")
        println("[2] United States Dollar (USD)")
        println("[3] Japanese Yen (JPY)")
        println("[4] British Pound Sterling (GBP)")
        println("[5] Euro (EUR)")
        println("[6] Chinese Yuan Renminni (CNY)\n")

        print("Exchange Currency: ")
        val target = readln().toInt()

        if (target !in 1..6) {
            println("Invalid target currency.")
            continue
        }

        if (target != 1 && rates[target] == 0.0) {
            println("Exchange rate has not been recorded.")
            println("Please record the exchange rate first")
            break
        }

        if (source == target) {
            println("Source and target currencies cannot be the same.")
            continue
        }

        val sourceRate = if (source == 1) 1.0 else rates.getValue(source)
        val targetRate = if (target == 1) 1.0 else rates.getValue(target)

        val phpAmount = amount * sourceRate
        val exchangedAmount = kotlin.math.round((phpAmount / targetRate) * 100) / 100

        balances[source] = kotlin.math.round((balances.getValue(source) - amount) * 100) / 100
        balances[target] = kotlin.math.round((balances.getValue(target) + exchangedAmount) * 100) / 100

        println("\nExchange Amount: %.2f".format(exchangedAmount))
        println("\nUpdated Balances:")
        additionalCurrency()
        println("PHP: %.2f".format(balances.getValue(1)))

        break
    }
}

fun interestAmount(balance: Double) {
    val annualInterest = 0.05f

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

fun recordExchangeRate() {

    println("[1] Philippine Peso (PHP) - 1")
    println("[2] United States Dollar (USD) - ${"%.2f".format(rates[2])}")
    println("[3] Japanese Yen (JPY) - ${"%.2f".format(rates[3])}")
    println("[4] British Pound Sterling (GBP) - ${"%.2f".format(rates[4])}")
    println("[5] Euro (EUR) - ${"%.2f".format(rates[5])}")
    println("[6] Chinese Yuan Renminni (CNY) - ${"%.2f".format(rates[6])}\n")

    print("Select Foreign Currency: ")
    val response = readln().toInt()

    if (response == 1) {
        println("PHP is the base currency")
        return
    }

    if (response !in rates) {
        println("Invalid currency selected")
        return
    }

    print("Exchange Rate: ")
    val newRate = readln().toDouble()

    rates[response] = newRate

    println("Rate updated successfully")

}

fun additionalCurrency() {
    for ((currency, amount) in balances) {

        if (currency != 1 && "%.2f".format(amount) != "0.00") {   // Skip PHP and zero balances

            when (currency) {
                2 -> println("USD: %.2f".format(amount))
                3 -> println("JPY: %.2f".format(amount))
                4 -> println("GBP: %.2f".format(amount))
                5 -> println("EUR: %.2f".format(amount))
                6 -> println("CNY: %.2f".format(amount))
            }

        }
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
    var name  = ""
    var flag = true

    while (flag) {

        println("=========================")
        println("Account Name: $name")
        println("Current Balance: ₱${"%.2f".format(balances[1])}")
        additionalCurrency()
        println("=========================")

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

        when (response) {
            1 -> name = registerAccountName()
            2 -> balances[1] = depositAccount(balances.getValue(1))
            3 -> balances[1] = withdrawAccount(balances.getValue(1))
            4 -> currencyExchange()
            5 -> recordExchangeRate()
            6 -> interestAmount(balances.getValue(1))
            7 -> flag = false
            else -> {
                println("Invalid option: Please try again.")
                continue
            }
        }
        if (response != 7) {
            if (!backToMainMenu()) {
                break
            }
        }
    }
}