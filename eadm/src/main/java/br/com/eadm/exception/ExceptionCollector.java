package br.com.eadm.exception;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionCollector {

	public ExceptionCollector() {
		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread arg0, Throwable e) {
				e.printStackTrace();
			}
		});
	}

}
