import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.valllent.shared.logic.di.DependenciesInitializer

fun main() {
    DependenciesInitializer.init()

    application {
        Window(onCloseRequest = ::exitApplication) {
            MainView()
        }
    }
}