# 实验一 数字图像处理编程基础
## 图像类型转换 点索引、灰度图、真彩图
```
% I=imread('F:/test.jpg');
I=imread('F:/gakki.bmp');
% imtool(I);
subplot(221);
imshow(I);
% imwrite(I,'image1copy.jpg');

[K,map]=rgb2ind(I,256);
subplot(223);
imshow(K);
% imagesc(K);
colormap(map);

J=rgb2gray(I);
subplot(222);
imshow(J);

L=ind2rgb(K,map);
subplot(224);
imshow(L);
```

## 图像实现   RGB真彩图转灰度图（库函数实现和编程实现）
```
I=imread('E:/cute.jpg');

J=rgb2gray(I);
subplot(221);imshow(I);
subplot(222);imshow(J);title('库函数实现');
imwrite(I,'E:/cute.bmp');

[x,y]=size(I);
img=zeros(x,y,1);
K=zeros(x,y);
img = ( (double(I(:,:,1))+double(I(:,:,2))+double(I(:,:,3) )) )/3;		%得到每一个RGB像素对应的分量I.(RGB转HSI模型的计算公式)
K=round(img(:,:,1));
subplot(223);imshow(uint8(K));title('手动实现');
```
