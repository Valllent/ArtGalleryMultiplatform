import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.valllent.shared.ui.di.DependenciesInitializer
import com.valllent.shared.ui.views.MainView

fun main() {
    DependenciesInitializer.init()

    application {
        Window(onCloseRequest = ::exitApplication) {
            MainView()
        }
    }
}