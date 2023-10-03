# Use an official Node.js runtime as the base image
FROM node:16.15.1

# Set the working directory in the container
WORKDIR /app

# Copy package.json and package-lock.json to the container
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of your application source code to the container
COPY . .

# Build the Vue.js app (you may need to adjust this command based on your project)
RUN npm run build

# Expose the port your Vue.js app will run on (adjust if needed)
EXPOSE 8082

# Define the command to serve your Vue.js app
CMD ["npm", "run", "start"]
