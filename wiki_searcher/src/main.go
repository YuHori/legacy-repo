package main

import (
  "flag"
  "io/ioutil"
  "log"
  "fmt"
  "net/http"
  "os"
  "regexp"
  "strings"
)

func main() {

  /* 引数処理 */
  var (
    word    string
    verbose bool
  )
  flag.StringVar(&word, "word", "聖書", "検索ワード")
  flag.StringVar(&word, "w"   , "聖書", "検索ワード")
  flag.BoolVar(&verbose, "v", false, "詳細表示")
  flag.Parse()

  /* クエリ作成 */
  wikiApiBase := "http://ja.wikipedia.org/w/api.php?format=xml&action=query&list=search&srsearch="
  query := wikiApiBase + word

  /* リクエスト発行・レスポンス取得 */
  res, err := http.Get(query)
  if err != nil {
    log.Printf("[ERROR] err : %s", err)
    os.Exit(1)
  }
  body, err := ioutil.ReadAll(res.Body)
  defer res.Body.Close()
  if err != nil {
    log.Printf("[ERROR] err : %s", err)
  }

  /* パース */
  r := regexp.MustCompile(`title="[^"]+"`)
  titleList := r.FindAllStringSubmatch(string(body), -1)
  for _, title := range titleList {
    kv := strings.Split(title[0], "=")
    if (verbose) {
      log.Printf("[INFO] %s\n", strings.Trim(kv[1], "\""))
    } else {
      fmt.Printf("%s\n", strings.Trim(kv[1], "\""))
    }
  }
}
