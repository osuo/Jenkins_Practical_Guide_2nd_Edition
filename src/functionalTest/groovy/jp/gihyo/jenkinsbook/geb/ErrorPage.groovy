package jp.gihyo.jenkinsbook.geb

import geb.Page

class ErrorPage extends Page {
    //
    static url = "";
    //
    static at = { title == 'エラー画面' }
    //
    static content = {
        結果 { $('p' ).text() }
    }
}
