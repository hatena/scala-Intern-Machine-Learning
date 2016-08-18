# intern.ml

Web開発におけるコンピュータサイエンス - 機械学習編 の課題雛形。

## セットアップ

```
$ sbt compile
```

もしくは

```
$ sbt
...
> compile
```

## コマンドの実行

```
$ sbt 'run <subcommand> <args>...'
```

もしくは

```
$ sbt
...
> run <subcommand> <args>...
```

利用可能なコマンドは

```
$ sbt run
```

で確認可能。

## 学習曲線の表示

### データセットの大きさを変えて実行

コマンドの引数にデータセットの大きさをとるようにしてあれば、`script/iterate.sh`を使って各大きさでコマンドを実行できます。

```
$ script/iterate.sh <num> <subcommand> <args>...
```

とすると

```
$ sbt 'run <subcommand> <args>... 1'
$ sbt 'run <subcommand> <args>... 2'
$ sbt 'run <subcommand> <args>... 3'
...
$ sbt 'run <subcommand> <args>... <num>'
```

とするのとだいたい同じになります。(警告などを表示しない、`sbt`の呼び出しを1回にまとめるなど細かな違いはあります。)

### グラフの表示

訓練データセットとテストデータセットの精度もしくは誤り率をスペース区切りにしたものを、データの大きさごとに1行ずつ出力したものを`script/plot.sh`の標準入力に渡すと学習曲線のグラフを表示できます。

`sbt 'run <subcommand> <args>... <num>'`が大きさ`<num>`の精度を1行出力するだけのスクリプトになっていれば、`script/iterate.sh`と併用して

```
$ script/iterate.sh <num> <subcommand> <args>... | script/plot.sh
```

などとできます。

グラフの表示には[gnuplot](http://www.gnuplot.info/)が必要です。
