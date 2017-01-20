package it.fabioformosa.jsouptest;

import java.io.IOException;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import junit.framework.Assert;

/**
 * App developed to reproduce the bug explained into the following stackoverflow
 * thread http://tinyurl.com/hnnsur3
 *
 */
public class App {

	private static final String URL = "http://www.altalex.com/documents/news/2016/12/06/questioni-civilistiche-conseguenti-alla-depenalizzazione";

	public static void main(String[] args) throws IOException {

		Response response = Jsoup.connect(URL) //
				.userAgent(
						"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36")
				.header("Accept",
						"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8") //
				.header("Accept-Encoding", "gzip, deflate, sdch") //
				.header("Accept-Language", "it,en-US;q=0.8,en;q=0.6")//
				.header("Upgrade-Insecure-Requests", "1")//
				.method(Method.GET) //
				.followRedirects(true).execute();

		Assert.assertEquals(200, response.statusCode());
	}
}
