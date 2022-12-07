package com.example.databindingdemoproject.batdongbo

data class DataResponse<out T>(
    val status: Status,
    val data : T?,
    val message :String?
) {
    companion object{
        fun <T> success(data: T): DataResponse<T> {
            return  DataResponse(status = Status.SUCCESS, data = data, message = null)
        }


        fun <T> error(data: T?,message: String?): DataResponse<T> =
            DataResponse(status = Status.ERROR, data = data, message = message)

        fun <T> loading(data: T?): DataResponse<T> =
            DataResponse(status = Status.LOAD, data = data, message = null)
    }
}