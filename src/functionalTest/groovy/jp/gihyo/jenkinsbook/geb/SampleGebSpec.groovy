package jp.gihyo.jenkinsbook.geb

import geb.spock.GebSpec

import spock.lang.Stepwise
import spock.lang.Unroll


@Unroll // メソッド名をテンプレート化
@Stepwise // メソッド定義順にテストを実行
class SampleGebSpec extends GebSpec {

    def "TopPageを表示して「#lastName」と「#firstName」で送信する"(lastName, firstName) {
        setup:
        to TopPage

        when:
        名字は lastName
        名前は firstName
        で送信する

        then:
        // assertは不要！
        at ResultPage
        結果 ==~ /Good .*, $lastName $firstName!!/ //正規表現の場合は ==~ で比較する

        where:
        lastName | firstName
        'aaa'    | 'bbb'
        'みょうじ'  | 'なまえ'
    }

    def "TopPageを表示して「#lastName」と「#firstName」で送信する NGケース"(lastName, firstName) {
        setup:
        to TopPage

        when:
        名字は lastName
        名前は firstName
        で送信する

        then:
        // assertは不要！
        at ErrorPage
        結果 == 'エラー'

        where:
        lastName | firstName
        'aaa'    | ''
        ''  | 'なまえ'
    }
}