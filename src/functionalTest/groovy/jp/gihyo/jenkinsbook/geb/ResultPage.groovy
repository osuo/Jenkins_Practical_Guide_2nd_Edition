package jp.gihyo.jenkinsbook.geb

import geb.Page

class ResultPage extends Page {
    //
    static url = "";
    //
    static at = { title == '結果画面' }
    //
    static content = {
        結果 { $('p' ).text() }
    }
}
