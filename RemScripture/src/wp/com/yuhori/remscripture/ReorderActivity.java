package wp.com.yuhori.remscripture;

import java.util.HashMap;
import java.util.Random;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ReorderActivity extends ActionBarActivity {

	// ハッシュ
	private HashMap<String, String> hashMap = new HashMap<String,String>();
	
	// すべてのキー
	private String[] keys;
	
	// 現在の番号
	private int nowNumber;
	
	// テキスト
	private TextView titleText;
	private TextView statementText;
	private TextView countText;
	
	// ボタン
	private Button openButton;
	private Button endButton;
	private Button nextButton;
	private Button backButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reorder_main);
		
		// テキストを取得
		titleText =(TextView)findViewById(R.id.title_text);
		statementText = (TextView)findViewById(R.id.statement_text);
		countText = (TextView)findViewById(R.id.count_text);
		
		// 聖句をハッシュにつめる。 -----------
		hashMap.put("レビ記19：11", "あなたたちは盗んではならない。うそをついてはならない。互いに欺いてはならない。");
		hashMap.put("民数記23：19", "神は人ではないから、偽ることはない。人の子ではないから、悔いることはない。言われたことを、なされないことがあろうか。告げられたことを、成就されないことがあろうか。");
		hashMap.put("ヨシュア1：8", "この律法の書をあなたの口から離すことなく、昼も夜も口ずさみ、そこに書かれていることをすべて忠実に守りなさい。そうすれば、あなたは、その行く先々で栄え、成功する。");
		hashMap.put("詩編119：9/11", "どのようにして、若者は／歩む道を清めるべきでしょうか。あなたの御言葉どおりに道を保つことです。/わたしは仰せを心に納めています／あなたに対して過ちを犯すことのないように。");
		hashMap.put("箴言3：9～10", "それぞれの収穫物の初物をささげ／豊かに持っている中からささげて主を敬え。そうすれば、主はあなたの倉に穀物を満たし／搾り場に新しい酒を溢れさせてくださる。");
		hashMap.put("イザヤ26：3", "堅固な思いを、あなたは平和に守られる／あなたに信頼するゆえに、平和に。");
		hashMap.put("イザヤ41：10", "恐れることはない、わたしはあなたと共にいる神。たじろぐな、わたしはあなたの神。勢いを与えてあなたを助け／わたしの救いの右の手であなたを支える。");
		hashMap.put("イザヤ53：6", "わたしたちは羊の群れ／道を誤り、それぞれの方角に向かって行った。そのわたしたちの罪をすべて／主は彼に負わせられた。");
		hashMap.put("哀歌3：22～23", "主の慈しみは決して絶えない。主の憐れみは決して尽きない。それは朝ごとに新たになる。「あなたの真実はそれほど深い。");
		hashMap.put("マタイ4：19", "イエスは、「わたしについて来なさい。人間をとる漁師にしよう」と言われた。");
		hashMap.put("マタイ5：16", "そのように、あなたがたの光を人々の前に輝かしなさい。人々が、あなたがたの立派な行いを見て、あなたがたの天の父をあがめるようになるためである。」");
		hashMap.put("マタイ6：33", "何よりもまず、神の国と神の義を求めなさい。そうすれば、これらのものはみな加えて与えられる。");
		hashMap.put("マタイ18：20", "二人または三人がわたしの名によって集まるところには、わたしもその中にいるのである。」");
		hashMap.put("マタイ28：19～20", "だから、あなたがたは行って、すべての民をわたしの弟子にしなさい。彼らに父と子と聖霊の名によって洗礼を授け、あなたがたに命じておいたことをすべて守るように教えなさい。わたしは世の終わりまで、いつもあなたがたと共にいる。」");
		hashMap.put("マルコ10：45", "人の子は仕えられるためではなく仕えるために、また、多くの人の身代金として自分の命を献げるために来たのである。」");
		hashMap.put("ルカ9：23", "それから、イエスは皆に言われた。「わたしについて来たい者は、自分を捨て、日々、自分の十字架を背負って、わたしに従いなさい。");
		hashMap.put("ヨハネ1：12", "しかし、言は、自分を受け入れた人、その名を信じる人々には神の子となる資格を与えた。");
		hashMap.put("ヨハネ5：24", "はっきり言っておく。わたしの言葉を聞いて、わたしをお遣わしになった方を信じる者は、永遠の命を得、また、裁かれることなく、死から命へと移っている。");
		hashMap.put("ヨハネ13：34～35", "あなたがたに新しい掟を与える。互いに愛し合いなさい。わたしがあなたがたを愛したように、あなたがたも互いに愛し合いなさい。互いに愛し合うならば、それによってあなたがたがわたしの弟子であることを、皆が知るようになる。」");
		hashMap.put("ヨハネ14：21", "わたしの掟を受け入れ、それを守る人は、わたしを愛する者である。わたしを愛する人は、わたしの父に愛される。わたしもその人を愛して、その人にわたし自身を現す。」");
		hashMap.put("ヨハネ15：7", "あなたがたがわたしにつながっており、わたしの言葉があなたがたの内にいつもあるならば、望むものを何でも願いなさい。そうすればかなえられる。");
		hashMap.put("使徒1：8", "あなたがたの上に聖霊が降ると、あなたがたは力を受ける。そして、エルサレムばかりでなく、ユダヤとサマリアの全土で、また、地の果てに至るまで、わたしの証人となる。」");
		hashMap.put("使徒24：16", "こういうわけで私は、神に対しても人に対しても、責められることのない良心を絶えず保つように努めています。");
		hashMap.put("ローマ1：16", "わたしは福音を恥としない。福音は、ユダヤ人をはじめ、ギリシア人にも、信じる者すべてに救いをもたらす神の力だからです。");
		hashMap.put("ローマ3：23", "人は皆、罪を犯して神の栄光を受けられなくなっていますが、");
		hashMap.put("ローマ4：20～21", "彼は不信仰に陥って神の約束を疑うようなことはなく、むしろ信仰によって強められ、神を賛美しました。神は約束したことを実現させる力も、お持ちの方だと、確信していたのです。");
		hashMap.put("ローマ5：8", "しかし、わたしたちがまだ罪人であったとき、キリストがわたしたちのために死んでくださったことにより、神はわたしたちに対する愛を示されました。");
		hashMap.put("ローマ6：23", "罪が支払う報酬は死です。しかし、神の賜物は、わたしたちの主キリスト・イエスによる永遠の命なのです。");
		hashMap.put("ローマ8：32", "わたしたちすべてのために、その御子をさえ惜しまず死に渡された方は、御子と一緒にすべてのものをわたしたちに賜らないはずがありましょうか。");
		hashMap.put("ローマ12：１", "こういうわけで、兄弟たち、神の憐れみによってあなたがたに勧めます。自分の体を神に喜ばれる聖なる生けるいけにえとして献げなさい。これこそ、あなたがたのなすべき礼拝です。");
		hashMap.put("ローマ12：2", "あなたがたはこの世に倣ってはなりません。むしろ、心を新たにして自分を変えていただき、何が神の御心であるか、何が善いことで、神に喜ばれ、また完全なことであるかをわきまえるようになりなさい。");
		hashMap.put("Ⅰコリント2：12", "わたしたちは、世の霊ではなく、神からの霊を受けました。それでわたしたちは、神から恵みとして与えられたものを知るようになったのです。");
		hashMap.put("Ⅰコリント3：16", "あなたがたは、自分が神の神殿であり、神の霊が自分たちの内に住んでいることを知らないのですか。");
		hashMap.put("Ⅰコリント15：58", "わたしの愛する兄弟たち、こういうわけですから、動かされないようにしっかり立ち、主の業に常に励みなさい。主に結ばれているならば自分たちの苦労が決して無駄にならないことを、あなたがたは知っているはずです。");
		hashMap.put("Ⅱコリント4：5", "わたしたちは、自分自身を宣べ伝えるのではなく、主であるイエス・キリストを宣べ伝えています。わたしたち自身は、イエスのためにあなたがたに仕える僕なのです。");
		hashMap.put("Ⅱコリント5：17", "だから、キリストと結ばれる人はだれでも、新しく創造された者なのです。古いものは過ぎ去り、新しいものが生じた。");
		hashMap.put("Ⅱコリント9：6～7", "つまり、こういうことです。惜しんでわずかしか種を蒔かない者は、刈り入れもわずかで、惜しまず豊かに蒔く人は、刈り入れも豊かなのです。各自、不承不承ではなく、強制されてでもなく、こうしようと心に決めたとおりにしなさい。喜んで与える人を神は愛してくださるからです。");
		hashMap.put("ガラテヤ2：20", "生きているのは、もはやわたしではありません。キリストがわたしの内に生きておられるのです。わたしが今、肉において生きているのは、わたしを愛し、わたしのために身を献げられた神の子に対する信仰によるものです。");
		hashMap.put("ガラテヤ6：9～10", "たゆまず善を行いましょう。飽きずに励んでいれば、時が来て、実を刈り取ることになります。ですから、今、時のある間に、すべての人に対して、特に信仰によって家族になった人々に対して、善を行いましょう。");
		hashMap.put("エフェソ2：8～9", "事実、あなたがたは、恵みにより、信仰によって救われました。このことは、自らの力によるのではなく、神の賜物です。行いによるのではありません。それは、だれも誇ることがないためなのです。");
		hashMap.put("エフェソ5：3", "あなたがたの間では、聖なる者にふさわしく、みだらなことやいろいろの汚れたこと、あるいは貪欲なことを口にしてはなりません。");
		hashMap.put("フィリピ2：3～4", "何事も利己心や虚栄心からするのではなく、へりくだって、互いに相手を自分よりも優れた者と考え、めいめい自分のことだけでなく、他人のことにも注意を払いなさい。");
		hashMap.put("フィリピ4：6～7", "どんなことでも、思い煩うのはやめなさい。何事につけ、感謝を込めて祈りと願いをささげ、求めているものを神に打ち明けなさい。そうすれば、あらゆる人知を超える神の平和が、あなたがたの心と考えとをキリスト・イエスによって守るでしょう。");
		hashMap.put("フィリピ4：13", "わたしを強めてくださる方のお陰で、わたしにはすべてが可能です。");
		hashMap.put("フィリピ4：19", "わたしの神は、御自分の栄光の富に応じて、キリスト・イエスによって、あなたがたに必要なものをすべて満たしてくださいます。");
		hashMap.put("Ⅱテモテ3：16", "聖書はすべて神の霊の導きの下に書かれ、人を教え、戒め、誤りを正し、義に導く訓練をするうえに有益です。");
		hashMap.put("テトス3：5", "神は、わたしたちが行った義の業によってではなく、御自分の憐れみによって、わたしたちを救ってくださいました。この救いは、聖霊によって新しく生まれさせ、新たに造りかえる洗いを通して実現したのです。");
		hashMap.put("ヘブル2：18", "事実、御自身、試練を受けて苦しまれたからこそ、試練を受けている人たちを助けることがおできになるのです。");
		hashMap.put("ヘブル9：27", "また、人間にはただ一度死ぬことと、その後に裁きを受けることが定まっているように、");
		hashMap.put("ヘブル10：24～25", "互いに愛と善行に励むように心がけ、ある人たちの習慣に倣って集会を怠ったりせず、むしろ励まし合いましょう。かの日が近づいているのをあなたがたは知っているのですから、ますます励まし合おうではありませんか。");
		hashMap.put("ヘブル11：6", "信仰がなければ、神に喜ばれることはできません。神に近づく者は、神が存在しておられること、また、神は御自分を求める者たちに報いてくださる方であることを、信じていなければならないからです。");
		hashMap.put("ヘブル12：3", "あなたがたが、気力を失い疲れ果ててしまわないように、御自分に対する罪人たちのこのような反抗を忍耐された方のことを、よく考えなさい。");
		hashMap.put("Ⅰペトロ2：11", "愛する人たち、あなたがたに勧めます。いわば旅人であり、仮住まいの身なのですから、魂に戦いを挑む肉の欲を避けなさい。");
		hashMap.put("Ⅰペトロ3：18", "キリストも、罪のためにただ一度苦しまれました。正しい方が、正しくない者たちのために苦しまれたのです。あなたがたを神のもとへ導くためです。キリストは、肉では死に渡されましたが、霊では生きる者とされたのです。");
		hashMap.put("Ⅰペトロ5：5～6", "同じように、若い人たち、長老に従いなさい。皆互いに謙遜を身に着けなさい。なぜなら、／「神は、高慢な者を敵とし、／謙遜な者には恵みをお与えになる」からです。だから、神の力強い御手の下で自分を低くしなさい。そうすれば、かの時には高めていただけます。");
		hashMap.put("Ⅰペトロ5：7", "思い煩いは、何もかも神にお任せしなさい。神が、あなたがたのことを心にかけていてくださるからです。");
		hashMap.put("Ⅰヨハネ2：15～16", "世も世にあるものも、愛してはいけません。世を愛する人がいれば、御父への愛はその人の内にありません。なぜなら、すべて世にあるもの、肉の欲、目の欲、生活のおごりは、御父から出ないで、世から出るからです。");
		hashMap.put("Ⅰヨハネ3：18", "子たちよ、言葉や口先だけではなく、行いをもって誠実に愛し合おう。");
		hashMap.put("Ⅰヨハネ5：13", "神の子の名を信じているあなたがたに、これらのことを書き送るのは、永遠の命を得ていることを悟らせたいからです。");
		hashMap.put("黙示録3：20", "見よ、わたしは戸口に立って、たたいている。だれかわたしの声を聞いて戸を開ける者があれば、わたしは中に入ってその者と共に食事をし、彼もまた、わたしと共に食事をするであろう。");
		// -------------------------------
		
		// キーをすべて取得
		keys = hashMap.keySet().toArray(new String[hashMap.size()]);

		//Fisher-Yatesアルゴリズムでシャッフルする
		Random rng = new Random();
		int n = keys.length;
		while (n > 1)
		{
		    n--;
		    int k = rng.nextInt(n + 1);
		    String tmp = keys[k];
		    keys[k] = keys[n];
		    keys[n] = tmp;
		}
		
		// 現在の番号
		nowNumber = 0;
		
		// ボタンにイベント設定
		openButton = (Button)findViewById(R.id.open_button);
		openButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	
            	// 表示
        		statementText.setVisibility(View.VISIBLE);
            }
        });
		
		// 終了ボタン
		endButton = (Button)findViewById(R.id.end_button);
		endButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	
            	// 閉じる
            	finish();
            }
        });
		
		// 次を表示
		nextButton = (Button)findViewById(R.id.next_button);
		nextButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	
            	// 現在の番号チェック
            	if(nowNumber == 59){
            	    //
            	    //処理：ダイアログを表示します。
            	    //
            	    AlertDialog.Builder alertDialog=new AlertDialog.Builder(ReorderActivity.this);
            	    //タイトルを設定する
            	    alertDialog.setTitle("確認");
            	    //メッセージ内容を設定する
            	    alertDialog.setMessage("終了します。よろしいですか？");
            	    //確認ボタン処理を設定する
            	    alertDialog.setPositiveButton("はい",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                	// 閉じる
                                	finish();
                                }
                            });
            	    alertDialog.setNeutralButton("いいえ",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                	// 処理せず終了
                                	return;
                                }
                            });
            	    alertDialog.create();
            	    alertDialog.show();
            	} else {
            		
	            	// 次を表示
	        		
	        		// 現在の番号
	        		nowNumber++;
	        		
	        		// テキストにセット
	        		titleText.setText(keys[nowNumber]);
	        		statementText.setText(hashMap.get(keys[nowNumber]));
	        		countText.setText(String.format("%d", nowNumber));
	        		
	        		// 非表示
	        		statementText.setVisibility(View.INVISIBLE);
            	}
            }
        });
		
		// 前を表示
		backButton = (Button)findViewById(R.id.back_button);
		backButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            		
            	// 現在の番号チェック
            	if(nowNumber == 0){
            	    //
            	    //処理：ダイアログを表示します。
            	    //
            	    AlertDialog.Builder alertDialog=new AlertDialog.Builder(ReorderActivity.this);
            	    //タイトルを設定する
            	    alertDialog.setTitle("確認");
            	    //メッセージ内容を設定する
            	    alertDialog.setMessage("終了します。よろしいですか？");
            	    //確認ボタン処理を設定する
            	    alertDialog.setPositiveButton("はい",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                	// 閉じる
                                	finish();
                                }
                            });
            	    alertDialog.setNeutralButton("いいえ",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                	// 処理せず終了
                                	return;
                                }
                            });
            	    alertDialog.create();
            	    alertDialog.show();
            	}else {
	            	// 前を表示
	        		
	        		// 現在の番号
	        		nowNumber--;
	        		
	        		// テキストにセット
	        		titleText.setText(keys[nowNumber]);
	        		statementText.setText(hashMap.get(keys[nowNumber]));
	        		countText.setText(String.format("%d", nowNumber));
	        		
	        		// 非表示
	        		statementText.setVisibility(View.INVISIBLE);
            	}
            }
        });
		
		// テキストにセット
		titleText.setText(keys[nowNumber]);
		statementText.setText(hashMap.get(keys[nowNumber]));
		countText.setText(String.format("%d", nowNumber));
		
		// 非表示
		statementText.setVisibility(View.INVISIBLE);

	}
}
