public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;
    }

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            callback.onDone("Task " + i + " is done");
        }
    }

    public void startAndError() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                errorCallback.onError(i + " - ERROR");
            }
            callback.onDone("Task " + i + " is done");

        }
    }
}
