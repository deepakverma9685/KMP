package data

import kotlinx.serialization.Serializable


@Serializable
data class LoginModel(
	val accountStatus: String? = null,
	val recentTransactionList: List<RecentTransactionListItem?>? = null,
	val errorMessageCode: String? = null,
	val TopUpAmount: String? = null,
	val AutoPay: String? = null,
	val userName: String? = null,
	val accountBalance: String? = null,
	val accountNumber: String? = null,
	val LowBalanceThrershold: String? = null,
	val status: String? = null
)


@Serializable
data class RecentTransactionListItem(
	val topUp: String? = null,
	val NorthBound: String? = null
)

