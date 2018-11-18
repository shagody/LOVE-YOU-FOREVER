# 实验二 图像几何变换

## 图像平移
```
init = rgb2gray(imread('F:/gakki.bmp')); % 读取图像
[R, C] = size(init); % 获取图像大小
res = zeros(R, C); % 构造结果矩阵。每个像素点默认初始化为0（黑色）
delX = 50; % 平移量X
delY = 50; % 平移量Y
tras = [1 0 delX; 0 1 delY; 0 0 1]; % 平移的变换矩阵 
for i = 1 : R
    for j = 1 : C
        temp = [i; j; 1];
        temp = tras * temp; % 矩阵乘法
        x = temp(1, 1);
        y = temp(2, 1);
        % 变换后的位置判断是否越界
        if (x <= R) && (y <= C) && (x >= 1) && (y >= 1)
            res(x, y) = init(i, j);
        end
    end
end
imshow(uint8(res)); % 显示图像
```
## 镜像变换
```
I=rgb2gray(imread('F:/gakki.bmp'));
subplot(131);imshow(I);title('原图像');
[r,c]=size(I);
res=zeros(r,c);
vmirror=[-1 0 0;0 1 0; 0 0 1];
hmirror=[1 0 0;0 -1 0;0 0 1];

for i=1:r
    for j=1:c
        temp=[i;j;1];
        temp=hmirror*temp;
        x=temp(1,1);
        y=temp(2,1);
        res(i,j)=I(x,y+c+1);
        %           res(i,j)=I(i,c-j+1);%以上等同这一句
    end
end
subplot(132);imshow(uint8(res));title('水平变换');

for i=1:r
    for j=1:c
        temp=[i;j;1];
        temp=vmirror*temp;
        x=temp(1,1);
        y=temp(2,1);
        res(i,j)=I(x+r+1,y);
        %         res(i,j)=I(r-i+1,j);%以上等同这一句
        
    end
end
subplot(133);imshow(uint8(res));title('垂直变换');
```    
## 图像缩放
```
init = rgb2gray(imread('F:/cute.jpg')); % 读取图像
figure(1);imshow(init);
[r, c] =size(init); % 获取图像大小
Sx = 0.5; % X轴缩放量
Sy = 1; % Y轴缩放量
res = zeros(Sx * r, Sy * c); % 构造结果矩阵。每个像素点默认初始化为0（黑色）
tras = [1/Sx 0 0; 0 1/Sy 0; 0 0 1]; % 缩放的变换矩阵 

for i = 1 : Sx * r
    for j = 1 : Sy * c
        temp = [i; j; 1];
        temp = double(tras) * double(temp); % 矩阵乘法
        x = round(temp(1, 1));
        y = round(temp(2, 1));
        % 变换后的位置判断是否越界
        if (x <= r) && (y <= c) && (x >= 1) && (y >= 1)
            res(i, j) = init(x, y);
        end
    end
end
figure(2);imshow(uint8(res)); % 显示图像
```
