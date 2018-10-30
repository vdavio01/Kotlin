package XpayAdapterWorksheet

class XpayToPayDAdapter(xpay: XpayImpl) : PayD {
    private val myXp = xpay

    override val custCardNo: String
        get() = myXp.creditCardNo
    override val cardOwnerName: String
        get() = myXp.customerName
    override val cardExpMonthDate: String
        get() = myXp.cardExpMonth
    override val CVVNo: Int
        get() = myXp.cardCVVNo.toInt()
    override val totalAmount: Double
        get() = myXp.amount

}


