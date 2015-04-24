/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.engine.impl.history.handler;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;

/**
 * @author Tom Baeyens
 * 
 *         TODO: Can probably be deleted
 */
public class ProcessInstanceEndHandler implements ExecutionListener {

  public void notify(DelegateExecution execution) {
    Context.getCommandContext().getHistoryManager()
        .recordProcessInstanceEnd(execution.getProcessInstanceId(), ((ExecutionEntity) execution).getDeleteReason(), ((ExecutionEntity) execution).getActivityId());
  }
}
