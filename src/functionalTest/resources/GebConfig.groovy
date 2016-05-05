// Gebの設定
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

// デフォルト設定
// Driverの設定
driver = { new FirefoxDriver() }

// レポート保存フォルダ
reportsDir = "target/geb-reports"

// テスト毎にCookieをクリアするかどうか　デフォルトはfalse
//autoClearCookies = false

// BaseUrlの設定
// PageクラスのURLはBaseUrlを起点とした相対パスでURLで指定する
baseUrl = "http://localhost/"

environments {
    // system property 'geb.env' を 'remote'にすると、以下の設定が使用される
    remote {
        baseUrl = "http://tomcat.hagi.home:8000/sampleproject/"
        driver = {
            def seleniumGridUrl = new URL("http://macmini.hagi.home:44444/wd/hub")
            new RemoteWebDriver(seleniumGridUrl, DesiredCapabilities.firefox())
        }
    }
    local {
        baseUrl = "http://tomcat.hagi.home:8000/sampleproject/"
    }
}

