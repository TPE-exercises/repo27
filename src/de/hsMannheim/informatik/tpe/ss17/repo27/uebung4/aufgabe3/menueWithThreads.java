package de.hsMannheim.informatik.tpe.ss17.repo27.uebung4.aufgabe3;

import java.util.Scanner;

public class menueWithThreads {

	public static void main(String[] args) throws InterruptedException {
	
		Ringpuffer rp = new Ringpuffer(4);
	
		putterThread put1 = new putterThread(rp, 10,"ErzeugerA");
//		putterThread put2 = new putterThread(rp, 200,"ErzeugerB");
//		putterThread put3 = new putterThread(rp, 250,"ErzeugerC");
		getterThread get1 = new getterThread(rp, 300, "VerbraucherX");
		getterThread get2 = new getterThread(rp, 450, "VerbraucherY");
        Thread thread[] = {put1,get1,get2};
		Timer timer = new Timer(0.10,thread);
        timer.start();
		put1.start();
//		put2.start();
//		put3.start();
		get1.start();
		get2.start();

	}
	}

