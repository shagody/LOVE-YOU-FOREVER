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
res = zeros(round(Sx * r), round(Sy * c)); % 构造结果矩阵。每个像素点默认初始化为0（黑色）
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
## 图像旋转1
```
init = rgb2gray(imread('F:/gakki.jpg')); % 读取图像
[R, C] = size(init); % 获取图像大小

alfa = -15 * pi / 180.0; % 旋转角度
cos_val	= cos(alfa);
sin_val	= sin(alfa);
R2=round(abs(cos_val)*R+C*abs(sin_val));
C2=round(abs(cos_val)*C+R*abs(sin_val));
res = zeros(R2,C2); % 构造结果矩阵。每个像素点默认初始化为0（黑色）
tras = [cos(alfa) -sin(alfa) 0; sin(alfa) cos(alfa) 0; 0 0 1]; % 旋转的变换矩阵

for i = 1 : R2
    for j = 1 : C2
        temp = [i; j; 1];
        temp = tras * temp;% 矩阵乘法
        x = uint16(temp(1, 1));
        y = uint16(temp(2, 1));
        % 变换后的位置判断是否越界
        if (x <= R2) && (y <= C2) && (x >= 1) && (y >= 1)
            res(i, j) = init(x, y);
        end
    end
end

imshow(uint8(res));  % 显示图像
```
## 图像旋转2
```
% 旋转后图像=my_img_rotate(原图像,旋转角度) 0<旋转角度<360
% 查找新图对应的原图像素点
% 最邻近点插值方法
I=imread('F:gakki.jpg');
angle=30;
[h,w,d]=size(I);
radian=angle/180*pi;
cos_val	= cos(radian);
sin_val	= sin(radian);
c=round(abs(cos_val)*w+h*abs(sin_val));
r=round(abs(cos_val)*h+w*abs(sin_val));
img_rotate	= uint8(zeros(r,c,3));	%像素是整数
for x=1:c
    for y=1:r
        x0 = uint32(x*cos_val + y*sin_val -0.5*c*cos_val-0.5*r*sin_val+0.5*w);
        y0= uint32(y*cos_val-x*sin_val+0.5*c*sin_val-0.5*r*cos_val+0.5*h);    
        
        x0=round(x0);         %最邻近插值
        y0=round(y0);         %最邻近插值
        if x0>0 && y0>0&& w >= x0&& h >= y0
            img_rotate(y,x,:) = I(y0,x0,:);
        end
    end
end
%I = imread('C:\Users\yytang\Desktop\love.jpg')
%I2=my_img_rotate(I,30);
figure,imshow(img_rotate);
```
## 图像旋转3
```
Image = rgb2gray(imread('F:/gakki.jpg'));
[X,Y]=size(Image); 

imshow(Image); 
Angle = pi/6;

%计算四个角点的新坐标，确定旋转后的显示区域 
LeftTop(1,1)=-(Y-1)*sin(Angle); 
LeftTop(1,2)=(Y-1)*cos(Angle); 

LeftBottom(1,1)=0; 
LeftBottom(1,2)=0; 

RightTop(1,1)=(X-1)*cos(Angle)-(Y-1)*sin(Angle); 
RightTop(1,2)=(X-1)*sin(Angle)+(Y-1)*cos(Angle); 

RightBottom(1,1)=(X-1)*cos(Angle); 
RightBottom(1,2)=(X-1)*sin(Angle); 

%计算显示区域的行列数 
Xnew=max([LeftTop(1,1),LeftBottom(1,1),RightTop(1,1),RightBottom(1,1)])-min([LeftTop(1,1),LeftBottom(1,1),RightTop(1,1),RightBottom(1,1)]); 
Ynew=max([LeftTop(1,2),LeftBottom(1,2),RightTop(1,2),RightBottom(1,2)])-min([LeftTop(1,2),LeftBottom(1,2),RightTop(1,2),RightBottom(1,2)]); 

% 分配新显示区域矩阵 
ImageNew=zeros(round(Xnew),round(Ynew)); 

%计算原图像各像素的新坐标 
for indexX=0:(X-1) 
    for indexY=0:(Y-1) 
      ImageNew(round(indexX*cos(Angle)-indexY*sin(Angle))+ ...
               round(abs(min([LeftTop(1,1),LeftBottom(1,1),...
          RightTop(1,1),RightBottom(1,1)])))+1,1+round(indexX*sin(Angle)+indexY*cos(Angle))+round(abs(min([LeftTop(1,2),LeftBottom(1,2),RightTop(1,2),RightBottom(1,2)]))))=Image(indexX+1,indexY+1); 
    end  
end 

h=(ImageNew)/255; 
h=medfilt2(h); 
figure,imshow(h) 
```
