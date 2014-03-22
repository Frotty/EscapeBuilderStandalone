/*
 * Copyright (c) 1996, 2010, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package de.fatochs.ebs.maze;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/**
 * This class implements a stream filter for writing compressed data in the GZIP
 * file format with the BEST_COMPRESSION deflater.
 * 
 * @author David Connelly
 */
public class MazeZipOut extends DeflaterOutputStream
{
	/**
	 * CRC-32 of uncompressed data.
	 */
	protected CRC32				crc				= new CRC32();

	/*
	 * GZIP header magic number.
	 */
	private final static int	GZIP_MAGIC		= 0x8b1f;

	/**
	 * Creates a new output stream with the specified buffer size and flush
	 * mode.
	 * 
	 * @param out
	 *            the output stream
	 * @param size
	 *            the output buffer size
	 * @param syncFlush
	 *            if {@code true} invocation of the inherited
	 *            {@link DeflaterOutputStream#flush() flush()} method of this
	 *            instance flushes the compressor with flush mode
	 *            {@link Deflater#SYNC_FLUSH} before flushing the output stream,
	 *            otherwise only flushes the output stream
	 * @exception IOException
	 *                If an I/O error has occurred.
	 * @exception IllegalArgumentException
	 *                if size is <= 0
	 * @since 1.7
	 */
	MazeZipOut(OutputStream out) throws IOException
	{
		super(out, new Deflater(Deflater.BEST_COMPRESSION, true),
				512,
				false);

		writeHeader();
		crc.reset();
	}

	/*
	 * Writes GZIP member header.
	 */
	private void writeHeader() throws IOException
	{
		out.write(new byte[] {
				(byte) GZIP_MAGIC, // Magic number (short)
				(byte) (GZIP_MAGIC >> 8), // Magic number (short)
				Deflater.DEFLATED, // Compression method (CM)
				0, // Flags (FLG)
				0, // Modification time MTIME (int)
				0, // Modification time MTIME (int)
				0, // Modification time MTIME (int)
				0, // Modification time MTIME (int)
				0, // Extra flags (XFLG)
				0 // Operating system (OS)
		});
	}
}
