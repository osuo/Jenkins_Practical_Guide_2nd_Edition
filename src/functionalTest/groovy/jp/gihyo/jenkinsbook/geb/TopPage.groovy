package jp.gihyo.jenkinsbook.geb

import geb.Page

class TopPage extends Page {
    // TopPageへの移動時に使用される
    static url = ""
    // TopPageを表示していることの確認
    static at = { title == '入力画面' }
    // TopPageのコンテンツ
    static content = {
        //
        名字 { $('label', for: 'LastName' ).text() }
            // itを引数にとる
            名字は { $('input', name: 'LastName' ).value(it) }
        //
        名前 { $('label', for: 'FirstName' ).text() }
            //
            名前は { $('input', name: 'FirstName' ).value(it) }
        // 送信.click()するとResultPageへ遷移する
        で送信する(to: ResultPage) { $('input', type: 'submit').click() }
    }
}
