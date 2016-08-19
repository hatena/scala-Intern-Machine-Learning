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
$ script/run <subcommand> <args>...
```

利用可能なコマンドは

```
$ script/run
```

で確認可能。

## 学習曲線の表示

### データセットの大きさを変えて実行

コマンドの引数にデータセットの大きさをとるようにしてあれば、`script/iterate`を使って各大きさでコマンドを実行できます。

```
$ script/iterate <num> <subcommand> <args>...
```

とすると

```
$ script/run <subcommand> <args>... 1
$ script/run <subcommand> <args>... 2
$ script/run <subcommand> <args>... 3
...
$ script/run <subcommand> <args>... <num>
```

とするのとだいたい同じになります。(警告などを表示しない、内部的な`sbt`の呼び出しを1回にまとめるなど細かな違いはあります。)

### グラフの表示

訓練データセットとテストデータセットの精度もしくは誤り率をスペース区切りにしたものを、データの大きさごとに1行ずつ出力したものを`script/plot`の標準入力に渡すと学習曲線のグラフを表示できます。

`script/run <subcommand> <args>... <num>`が大きさ`<num>`の精度を1行出力するだけのスクリプトになっていれば、`script/iterate`と併用して

```
$ script/iterate <num> <subcommand> <args>... | script/plot
```

などとできます。

グラフの表示には[gnuplot](http://www.gnuplot.info/)が必要です。
