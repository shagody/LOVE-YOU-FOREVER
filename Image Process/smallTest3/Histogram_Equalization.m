clc;
close all;
clear all;
 
src_img = rgb2gray(imread('test2.jpg'));  
 
figure (1) ;
subplot(321),imshow(src_img),title('原图像');%显示原始图像  
subplot(322),imhist(src_img),title('原图像直方图');%显示原始图像直方图  
 
matlab_eq=histeq(src_img);         %利用matlab的函数直方图均衡化
subplot(323),imshow(matlab_eq),title('matlab直方图均衡化原图像');%显示原始图像  
subplot(324),imhist(matlab_eq),title('matlab均衡化后的直方图');%显示原始图像直方图 
 
dst_img=myHE(src_img);             %利用自己写的函数直方图均衡化
subplot(325),imshow(dst_img),title('手写均衡化效果');%显示原始图像  
subplot(326),imhist(dst_img),title('手写均衡化直方图');%显示原始图像直方图 
