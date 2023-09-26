package queue;

import java.util.ArrayList;
import java.util.List;

public class QueueAnswer {

	/*
	 *データ構造の一つにキュー(待ち行列)があります。キューとは以下の条件を満たすデータ構造です。
	 *
	 *追加された要素は最後尾に追加される (enqueue)
	 *取り出される要素は先頭が取り出される(dequeue)
	 *
	 *このデータ構造を満たすようdequeue、enqueueメソッドを実装してQueueを完成させ実行結果と同じ実行結果になるように実装してください。
	 *
	 *-----実行結果-----
	 *==> 3, 1, 4
     *==> 1, 4
	 *==> 1, 4, 2
	 *==> 4, 2
     *==> 2
     *==>
	 */

	private List<Integer> queue;

	public static void main(String[] args) {
		QueueAnswer queue = new QueueAnswer();
		queue.enqueue(3);
		queue.enqueue(1);
		queue.enqueue(4);
		queue.print();
		queue.dequeue();
		queue.print();
		queue.enqueue(2);
		queue.print();
		queue.dequeue();
		queue.print();
		queue.dequeue();
		queue.print();
		queue.dequeue();
		queue.print();
	}

	public QueueAnswer() {
		this.queue = new ArrayList<Integer>();
	}

	public Integer dequeue() {
		Integer value = this.queue.get(0);//先頭の要素を取り出す
		this.queue.remove(0);//取り出した要素をリストから削除
		return value;
	}

	public void enqueue(Integer value) {
		this.queue.add(value);//後ろに追加する
	}

	public void print() {
		//正規表現 [, ] は\\でエスケープ処理 |で複数指定
		System.out.println("==> " + this.queue.toString().replaceAll("\\[|\\]", ""));
	}

}
