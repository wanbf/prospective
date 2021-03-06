package com.prospective.guava.concurrency;


import com.google.common.collect.Lists;

import static org.truth0.Truth.ASSERT;

import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Service;
import junit.framework.TestCase;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 */
public class AbstractIdleServiceTest extends TestCase {


    private static class DefaultService extends AbstractIdleService {
        @Override
        protected void startUp() throws Exception {
            System.out.println("startUp");
        }

        @Override
        protected void shutDown() throws Exception {
            System.out.println("shutDown");
        }
    }

    public void testServiceStartStop() throws Exception {
        AbstractIdleService service = new DefaultService();
        service.startAsync().awaitRunning();
        assertEquals(Service.State.RUNNING, service.state());
        service.stopAsync().awaitTerminated();
        assertEquals(Service.State.TERMINATED, service.state());
    }

    public void testStart_failed1() throws Exception {
        final Exception exception = new Exception("deliberate");
        AbstractIdleService service = new DefaultService() {
            @Override
            protected void startUp() throws Exception {
                throw exception;
            }
        };
        try {
            service.startAsync().awaitRunning();
            fail();
        } catch (RuntimeException e) {
            assertSame(exception, e.getCause());
        }
        assertEquals(Service.State.FAILED, service.state());
    }

    public void testStop_failed1() throws Exception {
        final Exception exception = new Exception("deliberate");
        AbstractIdleService service = new DefaultService() {
            @Override
            protected void shutDown() throws Exception {
                throw exception;
            }
        };
        service.startAsync().awaitRunning();
        try {
            service.stopAsync().awaitTerminated();
            fail();
        } catch (RuntimeException e) {
            assertSame(exception, e.getCause());
        }
        assertEquals(Service.State.FAILED, service.state());
    }

    public void testStart() {
        TestService service = new TestService();
        assertEquals(0, service.startUpCalled);
        service.startAsync().awaitRunning();
        assertEquals(1, service.startUpCalled);
        assertEquals(Service.State.RUNNING, service.state());
        ASSERT.that(service.transitionStates).has().exactly(Service.State.STARTING).inOrder();
    }

    public void testStart_failed() {
        final Exception exception = new Exception("deliberate");
        TestService service = new TestService() {
            @Override
            protected void startUp() throws Exception {
                super.startUp();
                throw exception;
            }
        };
        assertEquals(0, service.startUpCalled);
        try {
            service.startAsync().awaitRunning();
            fail();
        } catch (RuntimeException e) {
            assertSame(exception, e.getCause());
        }
        assertEquals(1, service.startUpCalled);
        assertEquals(Service.State.FAILED, service.state());
        ASSERT.that(service.transitionStates).has().exactly(Service.State.STARTING).inOrder();
    }

    public void testStop_withoutStart() {
        TestService service = new TestService();
        service.stopAsync().awaitTerminated();
        assertEquals(0, service.startUpCalled);
        assertEquals(0, service.shutDownCalled);
        assertEquals(Service.State.TERMINATED, service.state());
        ASSERT.that(service.transitionStates).isEmpty();
    }

    public void testStop_afterStart() {
        TestService service = new TestService();
        service.startAsync().awaitRunning();
        assertEquals(1, service.startUpCalled);
        assertEquals(0, service.shutDownCalled);
        service.stopAsync().awaitTerminated();
        assertEquals(1, service.startUpCalled);
        assertEquals(1, service.shutDownCalled);
        assertEquals(Service.State.TERMINATED, service.state());
        ASSERT.that(service.transitionStates)
                .has().exactly(Service.State.STARTING, Service.State.STOPPING).inOrder();
    }

    public void testStop_failed() {
        final Exception exception = new Exception("deliberate");
        TestService service = new TestService() {
            @Override
            protected void shutDown() throws Exception {
                super.shutDown();
                throw exception;
            }
        };
        service.startAsync().awaitRunning();
        assertEquals(1, service.startUpCalled);
        assertEquals(0, service.shutDownCalled);
        try {
            service.stopAsync().awaitTerminated();
            fail();
        } catch (RuntimeException e) {
            assertSame(exception, e.getCause());
        }
        assertEquals(1, service.startUpCalled);
        assertEquals(1, service.shutDownCalled);
        assertEquals(Service.State.FAILED, service.state());
        ASSERT.that(service.transitionStates)
                .has().exactly(Service.State.STARTING, Service.State.STOPPING).inOrder();
    }

    public void testServiceToString() {
        AbstractIdleService service = new TestService();
        assertEquals("TestService [NEW]", service.toString());
        service.startAsync().awaitRunning();
        assertEquals("TestService [RUNNING]", service.toString());
        service.stopAsync().awaitTerminated();
        assertEquals("TestService [TERMINATED]", service.toString());
    }

    public void testTimeout() throws Exception {
        Service service = new TestService() {
            @Override
            protected Executor executor() {
                return command -> {
                };
            }
        };
        try {
            service.startAsync().awaitRunning(100, TimeUnit.MILLISECONDS);
            fail("Expected timeout");
        } catch (TimeoutException e) {
            ASSERT.that(e.getMessage()).contains(Service.State.STARTING.toString());
        }
    }

    private static class TestService extends AbstractIdleService {
        int startUpCalled = 0;
        int shutDownCalled = 0;
        final List<State> transitionStates = Lists.newArrayList();

        @Override
        protected void startUp() throws Exception {
            assertEquals(0, startUpCalled);
            assertEquals(0, shutDownCalled);
            startUpCalled++;
            assertEquals(State.STARTING, state());
        }

        @Override
        protected void shutDown() throws Exception {
            assertEquals(1, startUpCalled);
            assertEquals(0, shutDownCalled);
            shutDownCalled++;
            assertEquals(State.STOPPING, state());
        }

        @Override
        protected Executor executor() {
            transitionStates.add(state());
            return MoreExecutors.sameThreadExecutor();
        }
    }
}