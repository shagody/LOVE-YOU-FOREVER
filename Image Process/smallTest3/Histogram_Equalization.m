clc;
close all;
clear all;
 
src_img = rgb2gray(imread('test2.jpg'));  
 
figure (1) ;
subplot(321),imshow(src_img),title('ԭͼ��');%��ʾԭʼͼ��  
subplot(322),imhist(src_img),title('ԭͼ��ֱ��ͼ');%��ʾԭʼͼ��ֱ��ͼ  
 
matlab_eq=histeq(src_img);         %����matlab�ĺ���ֱ��ͼ���⻯
subplot(323),imshow(matlab_eq),title('matlabֱ��ͼ���⻯ԭͼ��');%��ʾԭʼͼ��  
subplot(324),imhist(matlab_eq),title('matlab���⻯���ֱ��ͼ');%��ʾԭʼͼ��ֱ��ͼ 
 
dst_img=myHE(src_img);             %�����Լ�д�ĺ���ֱ��ͼ���⻯
subplot(325),imshow(dst_img),title('��д���⻯Ч��');%��ʾԭʼͼ��  
subplot(326),imhist(dst_img),title('��д���⻯ֱ��ͼ');%��ʾԭʼͼ��ֱ��ͼ 
