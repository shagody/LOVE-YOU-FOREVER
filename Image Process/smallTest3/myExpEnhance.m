function dst_img=myExpEnhance(src_img,Gamma)  
src_img = mat2gray(src_img,[0 255]);%��ͼ�����A�н���amin��amax�����ݹ�һ������ ����С��amin��Ԫ�ض���Ϊ0�� ����amax��Ԫ�ض���Ϊ1��  
C = 1;  
g2 = C*(src_img.^Gamma); 
%����һ��
max=255;
min=0;
dst_img=uint8(g2*(max-min)+min);
