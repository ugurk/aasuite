/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package template;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 *
 * @author Entokwaa
 */
@Retention(RUNTIME)
public @interface ChildRecords {
    ParentAddInfo[] info() default {};
    ChildRecord[] value();
}
