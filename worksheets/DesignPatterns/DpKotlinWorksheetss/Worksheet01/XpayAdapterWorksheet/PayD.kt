package XpayAdapterWorksheet

interface PayD {
    val custCardNo: String
    val cardOwnerName: String
    val cardExpMonthDate: String
    val CVVNo: Int
    val totalAmount: Double
}