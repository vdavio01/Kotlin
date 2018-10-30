package XpayAdapterWorksheet

class XpayImpl : Xpay {
    // and add appropriate mutators

    private var cardNumber = "0"
    private var usersName = ""
    private var expMonth = ""
    private var expYear = ""
    private var cvvNo : Short = 0
    private var deposit : Double = 0.0

    fun setCreditCardNo(creditCardNo: String) {
        cardNumber = creditCardNo
    }

    fun setCustomerName(name: String) {
        usersName = name
    }

    fun setCardExpMonth(expMonth: String) {

        this.expMonth = expMonth
    }

    fun setCardExpYear(expYear: String) {

        this.expYear = expYear
    }

    fun setCVVNo(cvvNo: Short) {
        this.cvvNo = cvvNo
    }

    fun setAmount(amount: Double) {
        deposit = amount
    }




    override val creditCardNo: String
        get() = cardNumber
    override val customerName: String
        get() = usersName
    override val cardExpMonth: String
        get() = expMonth
    override val cardExpYear: String
        get() = expYear
    override val cardCVVNo: Short
        get() = cvvNo
    override val amount: Double
        get() = deposit
}