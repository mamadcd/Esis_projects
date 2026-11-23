from flask import Flask, render_template
app = Flask(__name__)
@app.route("/")
def index():
    return "hi"

@app.route("/hello")
def hello():
    return render_template('hello.html')