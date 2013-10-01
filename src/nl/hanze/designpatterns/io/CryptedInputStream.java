package nl.hanze.designpatterns.io;

import java.io.BufferedReader;
import java.io.Reader;

public class CryptedInputStream extends BufferedReader
{
	public CryptedInputStream(Reader reader)
	{
		super(reader);
	}
}
