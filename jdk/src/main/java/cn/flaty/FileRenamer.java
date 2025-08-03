package cn.flaty;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileRenamer {

    public static void main(String[] args) {
        // 源文件夹路径
        String sourcePath = "D:\\zhou\\temp";
        // 目标文件夹路径
        String targetPath = "D:\\renames";
        // 需要删除的字符串
        String stringToRemove = "【宝宝巴士故事-安全警长啦咘啦哆】";

        try {
            renameAndCopyFiles(sourcePath, targetPath, stringToRemove);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void renameAndCopyFiles(String sourcePath, String targetPath, String stringToRemove) throws IOException {
        // 创建目标文件夹
        File targetDir = new File(targetPath);
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }

        // 获取源文件夹中的所有文件
        File sourceDir = new File(sourcePath);
        File[] files = sourceDir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // 获取原文件名
                    String originalName = file.getName();
                    // 生成新文件名（删除指定字符串）
                    String newName = originalName.replace(stringToRemove, " ");
                    newName = newName.replace("【宝宝巴士故事】", " ");
                    newName = newName.replace("【哆唻咪音乐小剧场】", " ");

                    // 创建目标文件对象
                    File targetFile = new File(targetPath + File.separator + newName);

                    // 复制文件到新位置
                    Files.copy(file.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                    System.out.println("Renamed and copied: " + originalName + " -> " + newName);
                }
            }
        }
    }
}
