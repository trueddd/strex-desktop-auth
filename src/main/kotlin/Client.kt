import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.html.div
import kotlinx.html.dom.append
import org.w3c.dom.Node

fun main() {
    window.onload = {
        document.body?.showUserInfo()
        sendTokenToApp()
    }
}

fun sendTokenToApp() {
    val data = document.location?.hash?.removePrefix("#") ?: return
    GlobalScope.launch {
        HttpClient().get<Unit>("http://localhost/login/desktop?$data")
    }
}

fun Node.showUserInfo() {
    append {
        div {
            + "You may now close this page."
        }
    }
}
