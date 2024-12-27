# Webアプリケーション ローカル環境セットアップ手順

以下の手順に従って、開発したWebアプリケーションをローカル環境で利用する準備を行ってください。

---

## 必要条件

1. **Java Development Kit (JDK)**
   - バージョン: 17
   - 他のバージョンでは動作確認を行っていません。

2. **PostgreSQL**
   - バージョン: 最新の安定版を推奨します。

3. **Git**
   - ソースコードをGitHubから取得するために必要です。

4. **IDEまたはエディタ**
   - IntelliJ IDEAまたはEclipseを推奨します。

---

## セットアップ手順

### 1. ソースコードのクローン

以下のコマンドを実行して、GitHubリポジトリをローカル環境にクローンします。
```bash
git clone <リポジトリURL>
cd <リポジトリ名>
```

### 2. データベースの設定

1. **PostgreSQLのインストールと起動**
   - PostgreSQLをインストールして起動します。

2. **データベースの作成とsqlファイルのインポート**
   - PostgreSQLコンソールまたはGUIツール（例: pgAdmin）を使用して、以下の手順を実行してください。
     1. 新しいデータベースを作成します。
        ```sql
        CREATE DATABASE <データベース名>;
        ```
     2. 作成したデータベースを選択して、GitHubリポジトリに含まれているsqlファイルをインポートします。
        ```bash
        psql -U <ユーザー名> -d <データベース名> -f <sqlファイルのパス>
        ```

### 3. アプリケーションのビルドと起動

1. **依存関係のインストール**
   - プロジェクトで使用しているビルドツール（例: MavenまたはGradle）に従い、依存関係をインストールします。
   ```bash
   # Mavenの場合
   mvn clean install

   # Gradleの場合
   gradle build
   ```

2. **アプリケーションの起動**
   - 以下のコマンドを実行して、アプリケーションを起動します。
   ```bash
   java -jar target/<アプリケーション名>.jar
   ```

3. **ブラウザで確認**
   - ブラウザを開き、以下のURLにアクセスしてください。
     ```

     http://localhost:8080
     ```

---

## テスト用アカウント

### 管理者用
- メールアドレス: `admin@admin.co.jp`
- パスワード: `admin123`

### 一般ユーザー用
- メールアドレス: `user@example.com`
- パスワード: `user456`

---

## 注意事項

- 本手順書はローカル環境での動作を前提としています。
- バージョン依存の問題を避けるため、指定されたバージョンのツールを使用してください。
