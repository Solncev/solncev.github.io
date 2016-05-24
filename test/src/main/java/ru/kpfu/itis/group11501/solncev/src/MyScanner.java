package ru.kpfu.itis.group11501.solncev.src;

import org.apache.commons.io.FileUtils;
import java.util.Iterator;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import java.io.File;
import java.io.IOException;

/**
 * Created by Марат on 20.05.2016.
 */


public class MyScanner{

    private File inputDir;
    private File outputDir;
    private String mask;
    private int waitInterval;
    private boolean includeSubfolders;
    private boolean autoDelete;

    public MyScanner(File inputDir, File outputDir, String mask, int waitInterval, boolean includeSubfolders, boolean autoDelete) {
        this.inputDir = inputDir;
        this.outputDir = outputDir;
        this.mask = mask;
        this.waitInterval = waitInterval;
        this.includeSubfolders = includeSubfolders;
        this.autoDelete = autoDelete;
    }

    public void scan(){

        IOFileFilter Filter = includeSubfolders ? TrueFileFilter.INSTANCE : FalseFileFilter.INSTANCE;

        Iterator<File> fileIterator = FileUtils.iterateFiles(inputDir, new WildcardFileFilter(mask), Filter);

        while(fileIterator.hasNext()){
            File input = fileIterator.next();
            File output = new File(outputDir.getPath() + input.getPath().substring(inputDir.getPath().length()));

            try{
                if (output.exists()) {
                    FileUtils.deleteQuietly(output);
                }
                if (autoDelete) {
                    FileUtils.moveFile(input, output);
                } else {
                    FileUtils.copyFile(input, output);
                }
            } catch (IOException e) {
                break;
            }

            try{
                TimeUnit.SECONDS.sleep(waitInterval);
            } catch (InterruptedException e) {
                break;
            }

        }

    }

}
