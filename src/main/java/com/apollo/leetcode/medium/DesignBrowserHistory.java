package com.apollo.leetcode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1472. Design Browser History
 * <p>
 * You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.
 * Implement the BrowserHistory class:
 * <p>
 * - BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
 * <p>
 * - void visit(string url) Visits url from the current page. It clears up all the forward history.
 * <p>
 * - string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
 * <p>
 * - string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.
 *
 * @see <a href="https://leetcode.com/problems/design-browser-history/">Design Browser History<a/>
 */
public class DesignBrowserHistory {

    private static abstract class BrowserHistory {

        public BrowserHistory(String homepage) {
            initHomepage(homepage);
        }

        protected abstract void initHomepage(String homepage);

        public abstract void visit(String url);

        public abstract String back(int steps);

        public abstract String forward(int steps);
    }

    private static class BrowserHistoryOne extends BrowserHistory {
        private List<String> history;
        private int historyLevel = 0;

        public BrowserHistoryOne(String homepage) {
            super(homepage);
        }

        @Override
        protected void initHomepage(String homepage) {
            history = new ArrayList<>();
            history.add(homepage);
        }

        @Override
        public void visit(String url) {
            if (historyLevel < history.size() - 1) {
                history = history.subList(0, historyLevel + 1);
            }

            history.add(url);
            historyLevel++;
        }

        @Override
        public String back(int steps) {
            historyLevel = Math.max(0, historyLevel - steps);
            return history.get(historyLevel);
        }

        @Override
        public String forward(int steps) {
            historyLevel = Math.min(history.size() - 1, historyLevel + steps);
            return history.get(historyLevel);
        }
    }

    private static class BrowserHistoryTwo extends BrowserHistory {
        private BrowserHistoryItem history;

        public BrowserHistoryTwo(String homepage) {
            super(homepage);
        }

        @Override
        protected void initHomepage(String homepage) {
            history = new BrowserHistoryItem(homepage);
        }

        @Override
        public void visit(String url) {
            BrowserHistoryItem item = new BrowserHistoryItem(url);
            history.setNext(item);
            history = item;
        }

        @Override
        public String back(int steps) {
            while (steps > 0 && history.getPrev() != null) {
                history = history.getPrev();
                steps--;
            }
            return history.getUrl();
        }

        @Override
        public String forward(int steps) {
            while (steps > 0 && history.getNext() != null) {
                history = history.getNext();
                steps--;
            }
            return history.getUrl();
        }
    }

    private static class BrowserHistoryItem {
        private final String url;
        private BrowserHistoryItem prev;
        private BrowserHistoryItem next;

        public BrowserHistoryItem(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public BrowserHistoryItem getPrev() {
            return prev;
        }

        public void setPrev(BrowserHistoryItem prev) {
            prev.next = this;
            this.prev = prev;
        }

        public BrowserHistoryItem getNext() {
            return next;
        }

        public void setNext(BrowserHistoryItem next) {
            next.prev = this;
            this.next = next;
        }
    }

    public List<String> useBrowserHistoryOne(List<String> commands, List<String> args) {
        return useBrowserHistory(commands, args, BrowserHistoryOne::new);
    }

    public List<String> useBrowserHistoryTwo(List<String> commands, List<String> args) {
        return useBrowserHistory(commands, args, BrowserHistoryTwo::new);
    }

    private List<String> useBrowserHistory(List<String> commands,
                                           List<String> args,
                                           BrowserHistoryFactory factory) {

        List<String> result = new ArrayList<>();
        BrowserHistory browserHistory = null;

        Iterator<String> commandsIterator = commands.iterator();
        Iterator<String> argsIterator = args.iterator();

        while (commandsIterator.hasNext() && argsIterator.hasNext()) {
            String command = commandsIterator.next();
            String arg = argsIterator.next();

            switch (command) {
                case BrowserCommands.BROWSER_HISTORY:
                    browserHistory = factory.create(arg);
                    result.add(null);
                    break;
                case BrowserCommands.VISIT:
                    if (browserHistory == null) throw getIllegalException();
                    browserHistory.visit(arg);
                    result.add(null);
                    break;
                case BrowserCommands.BACK:
                    if (browserHistory == null) throw getIllegalException();
                    result.add(browserHistory.back(Integer.parseInt(arg)));
                    break;
                case BrowserCommands.FORWARD:
                    if (browserHistory == null) throw getIllegalException();
                    result.add(browserHistory.forward(Integer.parseInt(arg)));
                    break;
            }
        }

        return result;
    }

    private IllegalStateException getIllegalException() {
        return new IllegalStateException("BrowserHistory isn't initialized");
    }

    @FunctionalInterface
    private interface BrowserHistoryFactory {

        BrowserHistory create(String homepage);
    }

    public static class BrowserCommands {

        public static final String BROWSER_HISTORY = "BrowserHistory";

        public static final String VISIT = "visit";

        public static final String BACK = "back";

        public static final String FORWARD = "forward";
    }
}
