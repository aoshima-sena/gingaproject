package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {
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
		Queue queue = new Queue();
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

	public Queue() {
		this.queue = new ArrayList<Integer>();
	}

	public Integer dequeue() {

	}

	public void enqueue(Integer value) {

	}

	public void print() {
		//正規表現 [, ] は\\でエスケープ処理 |で複数指定
		System.out.println("==> " + this.queue.toString().replaceAll("\\[|\\]", ""));
	}

}
