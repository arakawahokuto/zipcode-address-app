# 郵便番号住所検索アプリ（Zipcode Address App）

## 概要

7桁の郵便番号を入力すると、APIから住所を取得して表示・履歴保存できるJavaアプリです。

- 郵便番号に対応する都道府県・市区町村・町域を取得
- 取得した住所は履歴として保持され、一覧表示が可能
- CSV形式で履歴を保存可能

## 機能

- 郵便番号から住所を取得
- 「履歴」と入力すると取得済みの住所一覧を表示
- 「保存」と入力すると履歴を address.csv に保存
- 「exit」でプログラムを終了

## 使用技術

- Java（JDK 17 推奨）
- JSONパースライブラリ（json-20230618.jar）
- API：zipaddress.net

## 実行方法

1. このリポジトリをクローンまたはダウンロード
2. 以下のコマンドでコンパイル・実行
3. 表示に従って郵便番号を入力

## ファイル構成
├── MainApp.java
├── Address.java
├── ApiClient.java
├── ZipcodeService.java
├──json-20230618.jar
├── .gitignore
└── README.md

## 備考
このアプリはJava学習の一環として開発されました。
