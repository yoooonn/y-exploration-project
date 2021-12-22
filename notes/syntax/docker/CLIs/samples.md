```sh
docker run -p 9000:9000 --name minio \
  -v ~/Docker-sharing/minio/data:/data \
  -v ~/Docker-sharing/minio/:/root/.minio \
  -e 'MINIO_ROOT_USER=root' \
  -e 'MINIO_ROOT_PASSWORD=root' \
  minio/minio:latest server /data
```

