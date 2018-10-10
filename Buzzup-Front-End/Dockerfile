FROM node:latest
RUN mkdir -p /buzzup
WORKDIR /buzzup
COPY package.json /buzzup/
RUN npm install --force
RUN npm cache verify
COPY . /buzzup
EXPOSE 4200/tcp
CMD ["npm", "start", "--", "--host", "0.0.0.0", "--poll", "2000"]
