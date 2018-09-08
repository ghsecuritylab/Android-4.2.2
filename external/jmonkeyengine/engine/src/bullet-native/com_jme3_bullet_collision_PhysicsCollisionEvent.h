/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_jme3_bullet_collision_PhysicsCollisionEvent */

#ifndef _Included_com_jme3_bullet_collision_PhysicsCollisionEvent
#define _Included_com_jme3_bullet_collision_PhysicsCollisionEvent
#ifdef __cplusplus
extern "C" {
#endif
#undef com_jme3_bullet_collision_PhysicsCollisionEvent_serialVersionUID
#define com_jme3_bullet_collision_PhysicsCollisionEvent_serialVersionUID 5516075349620653480LL
#undef com_jme3_bullet_collision_PhysicsCollisionEvent_TYPE_ADDED
#define com_jme3_bullet_collision_PhysicsCollisionEvent_TYPE_ADDED 0L
#undef com_jme3_bullet_collision_PhysicsCollisionEvent_TYPE_PROCESSED
#define com_jme3_bullet_collision_PhysicsCollisionEvent_TYPE_PROCESSED 1L
#undef com_jme3_bullet_collision_PhysicsCollisionEvent_TYPE_DESTROYED
#define com_jme3_bullet_collision_PhysicsCollisionEvent_TYPE_DESTROYED 2L
/*
 * Class:     com_jme3_bullet_collision_PhysicsCollisionEvent
 * Method:    getAppliedImpulse
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_com_jme3_bullet_collision_PhysicsCollisionEvent_getAppliedImpulse
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_jme3_bullet_collision_PhysicsCollisionEvent
 * Method:    getAppliedImpulseLateral1
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_com_jme3_bullet_collision_PhysicsCollisionEvent_getAppliedImpulseLateral1
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_jme3_bullet_collision_PhysicsCollisionEvent
 * Method:    getAppliedImpulseLateral2
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_com_jme3_bullet_collision_PhysicsCollisionEvent_getAppliedImpulseLateral2
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_jme3_bullet_collision_PhysicsCollisionEvent
 * Method:    getCombinedFriction
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_com_jme3_bullet_collision_PhysicsCollisionEvent_getCombinedFriction
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_jme3_bullet_collision_PhysicsCollisionEvent
 * Method:    getCombinedRestitution
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_com_jme3_bullet_collision_PhysicsCollisionEvent_getCombinedRestitution
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_jme3_bullet_collision_PhysicsCollisionEvent
 * Method:    getDistance1
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_com_jme3_bullet_collision_PhysicsCollisionEvent_getDistance1
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_jme3_bullet_collision_PhysicsCollisionEvent
 * Method:    getIndex0
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_com_jme3_bullet_collision_PhysicsCollisionEvent_getIndex0
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_jme3_bullet_collision_PhysicsCollisionEvent
 * Method:    getIndex1
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_com_jme3_bullet_collision_PhysicsCollisionEvent_getIndex1
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_jme3_bullet_collision_PhysicsCollisionEvent
 * Method:    getLateralFrictionDir1
 * Signature: (JLcom/jme3/math/Vector3f;)V
 */
JNIEXPORT void JNICALL Java_com_jme3_bullet_collision_PhysicsCollisionEvent_getLateralFrictionDir1
  (JNIEnv *, jobject, jlong, jobject);

/*
 * Class:     com_jme3_bullet_collision_PhysicsCollisionEvent
 * Method:    getLateralFrictionDir2
 * Signature: (JLcom/jme3/math/Vector3f;)V
 */
JNIEXPORT void JNICALL Java_com_jme3_bullet_collision_PhysicsCollisionEvent_getLateralFrictionDir2
  (JNIEnv *, jobject, jlong, jobject);

/*
 * Class:     com_jme3_bullet_collision_PhysicsCollisionEvent
 * Method:    isLateralFrictionInitialized
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_com_jme3_bullet_collision_PhysicsCollisionEvent_isLateralFrictionInitialized
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_jme3_bullet_collision_PhysicsCollisionEvent
 * Method:    getLifeTime
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_com_jme3_bullet_collision_PhysicsCollisionEvent_getLifeTime
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_jme3_bullet_collision_PhysicsCollisionEvent
 * Method:    getLocalPointA
 * Signature: (JLcom/jme3/math/Vector3f;)V
 */
JNIEXPORT void JNICALL Java_com_jme3_bullet_collision_PhysicsCollisionEvent_getLocalPointA
  (JNIEnv *, jobject, jlong, jobject);

/*
 * Class:     com_jme3_bullet_collision_PhysicsCollisionEvent
 * Method:    getLocalPointB
 * Signature: (JLcom/jme3/math/Vector3f;)V
 */
JNIEXPORT void JNICALL Java_com_jme3_bullet_collision_PhysicsCollisionEvent_getLocalPointB
  (JNIEnv *, jobject, jlong, jobject);

/*
 * Class:     com_jme3_bullet_collision_PhysicsCollisionEvent
 * Method:    getNormalWorldOnB
 * Signature: (JLcom/jme3/math/Vector3f;)V
 */
JNIEXPORT void JNICALL Java_com_jme3_bullet_collision_PhysicsCollisionEvent_getNormalWorldOnB
  (JNIEnv *, jobject, jlong, jobject);

/*
 * Class:     com_jme3_bullet_collision_PhysicsCollisionEvent
 * Method:    getPartId0
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_com_jme3_bullet_collision_PhysicsCollisionEvent_getPartId0
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_jme3_bullet_collision_PhysicsCollisionEvent
 * Method:    getPartId1
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_com_jme3_bullet_collision_PhysicsCollisionEvent_getPartId1
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_jme3_bullet_collision_PhysicsCollisionEvent
 * Method:    getPositionWorldOnA
 * Signature: (JLcom/jme3/math/Vector3f;)V
 */
JNIEXPORT void JNICALL Java_com_jme3_bullet_collision_PhysicsCollisionEvent_getPositionWorldOnA
  (JNIEnv *, jobject, jlong, jobject);

/*
 * Class:     com_jme3_bullet_collision_PhysicsCollisionEvent
 * Method:    getPositionWorldOnB
 * Signature: (JLcom/jme3/math/Vector3f;)V
 */
JNIEXPORT void JNICALL Java_com_jme3_bullet_collision_PhysicsCollisionEvent_getPositionWorldOnB
  (JNIEnv *, jobject, jlong, jobject);

#ifdef __cplusplus
}
#endif
#endif
