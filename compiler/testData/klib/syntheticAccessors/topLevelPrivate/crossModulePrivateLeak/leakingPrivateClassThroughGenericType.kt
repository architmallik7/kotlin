// IGNORE_BACKEND: ANY

// MODULE: lib
// FILE: a.kt
private class Private

private inline fun <reified T> parameterized(): String {
    if (T::class == Private::class) return "OK"
    return T::class.simpleName ?: "Unknown type"
}

internal inline fun inlineFun() = parameterized<Private>()

// MODULE: main()(lib)
// FILE: main.kt
fun box(): String {
    return inlineFun()
}
