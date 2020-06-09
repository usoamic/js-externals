package js.externals.toastr

@JsModule("toastr")
@JsNonModule
external class toastr {
    companion object {
        fun error(message: String)
        fun warning(message: String)
        fun success(message: String)
        fun info(message: String)
    }
}